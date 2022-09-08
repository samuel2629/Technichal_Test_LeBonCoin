Cette application est structurée de manière à pouvoir faire évoluer le projet sur du long terme, bien que pour une si petite application cela semble faire beaucoup de code, cela est nécessaire d'avoir une Clean Architecture afin d'avoir une base solide sur laquelle construire.

Elle est découpée en 5 grands packages:
- Common : Le package qui contient ce qui est commun à tout le projet
- Data : Le package qui contient tout ce qui est relatif aux données
- DI : Le package de Dependency Injection
- Domain : Le package qui fait le lien entre les données et L'UI
- Presentation : Le package qui affiche l'UI

Au niveau de l'UI, le view binding ainsi que le navigation component sont implémentés.

Au niveau des libraires utilisées :

- navigation-fragment et navigation-ui : Nécesseraires pour la navigation, recommandé par Google.
- coil : Nécessaire au traitement des images, choisi à la place de Glide ou Picasso car soutenu par Kotlin et plus léger
- room : Nécessaire pour la base de donnée, recommandé par Google.
- hilt : Nécessaire à l'injection des dépendances, recommandé par Google.
- retrofit : Nécessaire aux appels réseau, choisi car le plus robuste et le plus largement utilisé.
- truth : Nécessaire à la clarté du code test
- Toutes les autres libraires, sont les dernieres versions nécessaire a faire tourner le code.

Le projet est pensé pour séparer les différents aspects de l'application, comme cela est recommandé et nécessaire, ainsi les données ne sont jamais couplés directement avec l'UI, elles passent nécessairement par la couche domain qui expose à l'UI un flow afin d'afficher le strict nécessaire.
C'est également pour cela que la couche domain possède un package repository, afin de faciliter les tests.

Enfin, vu la simplicité du design, le projet ne teste pas l'UI.
