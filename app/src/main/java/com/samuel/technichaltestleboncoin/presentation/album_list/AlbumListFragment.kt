package com.samuel.technichaltestleboncoin.presentation.album_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.samuel.technichaltestleboncoin.R
import com.samuel.technichaltestleboncoin.databinding.AlbumListFragmentBinding
import com.samuel.technichaltestleboncoin.domain.model.Album
import com.samuel.technichaltestleboncoin.presentation.ui.adapter.AlbumItemAdapter

class AlbumListFragment: Fragment() {

    private var _binding: AlbumListFragmentBinding? = null
    private val binding get() = _binding!!
    private val _albumListViewModel : AlbumListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AlbumListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if(_albumListViewModel.state.value!!.albums.isEmpty())
             _albumListViewModel.state.observe(viewLifecycleOwner) {

                 /** LOADING STATE ACTION **/
                 if(it.isLoading) binding.albumListFragmentPb.visibility = View.VISIBLE
                 else binding.albumListFragmentPb.visibility = View.GONE

                 /** ERROR STATE ACTION **/
                 if(it.isError) {
                     binding.albumListFragmentErrorCl.visibility = View.VISIBLE
                     binding.albumListFragmentErrorTv.text = it.error ?:
                             getString(R.string.unexpected_error_message)
                     binding.albumListFragmentErrorBtn.setOnClickListener { _albumListViewModel.getAlbums() }
                 } else binding.albumListFragmentErrorCl.visibility = View.GONE

                 /** SUCCESS STATE ACTION **/
                 setAlbumListIntoRecyclerview(it.albums)
             }
        else setAlbumListIntoRecyclerview(_albumListViewModel.state.value!!.albums)
    }

    private fun setAlbumListIntoRecyclerview(albums: List<Album>) {
        binding.albumListFragmentRv.apply {
            adapter = AlbumItemAdapter(albums)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}