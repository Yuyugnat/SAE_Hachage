# SAE_Hachage

# Question 1 :

En prenant en compte les 256 caractères possibles et en nommant U l'ensemble
des chaines d'au plus 30 caractères, 
|U| vaut 256^30 soit un nombre supérieur à 10^72.

Même avec 32 caractères possibles,
|U| vaut 32^30 soit un nombre superieur à 10^45;


# Question 2 :

En supposant que  U = [0, x], une structure de données très efficace pour
botenir la propriété p2 est d'utiliser un tableau de booléens où chaque case vaudra 'true'
si la valeur correspondant à l'indice est présente et 'false' sinon


# Question 3 :

Un octet permet de coder 256 valeurs différentes.
En reprenant l'exemple où les caractères possibles dans une chaine sont au nombre de 256
et où leur longueur  vont jusqu'à 32 caractères, on a toujours 256^32 valeurs différentes possibles.
Pour obtenir la place en octets il suffit de diviser par le nombre de valeurs différentes que 
peut encoder un octet, ce qui donne 256^32 / 256 = 256^31 octets nécessaire pour stocker un élément de U.


# Question 18 :

En calculant indépendamment chaque caractères on obtient un nombre de multiplication
qui grandit de manière exponentielle avec la longueur du mot :
il s'agit de la somme pour i allant de 1 à la longueur du mot, des i
Donc pour un mot de taille k  cela donnera donc k * (k + 1) / 2 multiplication (c'est beaucoup)
Preuve : pour chaque caractère, on a i - 1 multiplications pour calculer la puissance de 256,
puis une multiplication par le code ASCII.


# Question 25 :

Pour m == 1 :\n

maxSize : 21393\n
cardinal : 21393\n
nbListes : 1\n
totalTimeh : 22 ms\n
totalTimeContient : 7047 ms\n
temps total : 11069 ms\n

Pour m == 2 : 

maxSize : 11509
cardinal : 21393
nbListes : 2
totalTimeh : 33 ms
totalTimeContient : 5387 ms
temps total : 6126 ms

Pour m == 4 :

maxSize : 6624
cardinal : 21393
nbListes : 4
totalTimeh : 15 ms
totalTimeContient : 3339 ms
temps total : 3238 ms

Pour m == 8 :

maxSize : 4151
cardinal : 21393
nbListes : 8
totalTimeh : 33 ms
totalTimeContient : 1753 ms
temps total : 1910 ms


# Question 26 : 

Pour f == 0.01 : 

maxSize : 196
cardinal : 500000
nbListes : 5000
totalTimeh : 125 ms
totalTimeContient : 4401 ms
temps total : 1266 ms

Pour f == 0.1 :

maxSize : 47
cardinal : 500000
nbListes : 50000
totalTimeh : 137 ms
totalTimeContient : 669 ms
temps total : 315 ms

Pour f == 0.5 :

maxSize : 18
cardinal : 500000
nbListes : 250000
totalTimeh : 145 ms
totalTimeContient : 374 ms
temps total : 309 ms

Pour f == 1.0 :

maxSize : 18
cardinal : 500000
nbListes : 500000
totalTimeh : 144 ms
totalTimeContient : 250 ms
temps total : 292 ms


# Question 27 :

Il y a 14445 mots différents dans 'LeRougeEtLeNoir.txt'
