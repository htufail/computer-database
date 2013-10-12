Julia Fauvel Hina Tufail

------------------------------------------------------------------
CORRECTION+CODE REVIEW:
------------------------------------------------------------------

-------------------------
Expérience utilisateur:
-------------------------
On arrive sur la page principale, tout a l'air normal. Pas de order by, ok c'etait en plus mais bon...

L'affichage de la date est facilité (on n'affiche pas les secondes etc...), j'aime!

L'ordre de départ aurait pu être le Computer Name, dommage!

Recherche: dommage! la recherche change le nombre d'ordinateurs, mais je perds la pagination et je tire tous les resultats! Si j'ai tape "A" je me retrouve avec presque 400 entrees...

Ajout d'ordinateur: Aucun controle n'est visible. Comment l'utilisateur va-t-il savoir qu'il a mal remplit un champ?
D'autre part, meme si je ne sais rien, je devrais toujours avoir mes champs remplis jusqu'a ce que ca marche. 
Niveau experience utilisateur on est quand meme loins...
Autre probleme, "Please match the requested format", erreur de validateur causee par votre attribut pattern dans le champ date, sette a YY-MM-DD dans votre formulaire (donc déjà, ca devrait être YYYY-MM-DD). Mais ca ne suffit pas: ce pattern est une expression régulière (ou regex), quand vous mettez ceci en pattern, il va chercher la chaine "YYYY-MM-DD", alors que vous voulez en réalité quatre chiffres, un tiret, deux chiffres <= 12, un tiret etc... il aurait fallu écrire un truc du style:

(19[6-9][0-9]|20[0-9][0-9])\-(0?[1-9]|1[12])\-(0?[1-9]|[1-2][0-9]|3[01])

Sur un navigateur vieux (genre celui d'eclipse) ca marchera.

Edit d'ordinateur:
Les dates sont préremplies: bravo!
Par contre, que se passe-t-il quand il n'y avait pas de date?

Delete: Ok, mais quand j'annule, j'aurais aime rester sur le edit Computer (car potentiellement, c'etait une erreur de clic de bouton).

-------------------------
Le code:
-------------------------
-Commentaires: yes! un peu plus d'efforts pour la javadoc, n'hésitez pas à rajouter @author, @returns, @param etc...

-Protection des jsp: bien

-Utilisation des builder: bien!

-Utilisation des enums pour les singletons: yes!

-Controllers: Les variables qui ne bougeront pas (le nombre de resultats par page par exemple) devraient etre des variables private static final. Comme ca, vous ne creez pas une instance par affichage de page!
EditController: euh... Les message dialog commentes? c'est pour ca que je n'ai rien! Vous auriez pu vous donner le temps d'implementer quelque chose d'autre, meme plus simple.

-Services: RAS si ce n'est que un GeneralService aurait pu etre scinde en deux. Mais bon dans notre cas ca n'a pas beaucoup d'importance.

-Dao: RAS (bien pour les try finally)
-Domain: RAS

-JSP: C'est bien. le code est clair et indenté.

Votre pagination n'est pas trop lourde, c'est bien. Dommage qu'elle ne fonctionne pas pour tout par contre...
Les scripts auraient du/pu etre exportes dans un fichier js. Ca ameliore la maintenabilite du code.

-------------------------
Bilan: 
-------------------------
Projet moyen, vous n'avez pas pousse aussi loin que certains et vous etes arretes au strict minimum.
Ca aurait ete suffisant si la recherche et la pagination auraient marche ensemble, mais la je reste un peu sur ma faim. Pour l'ajout, pareil, n'oubliez pas que ce qui importe avant TOUT, c'est l'experience utilisateur.
Cote code, ca va, vous n'avez pas fait d'erreur monstrueuse et le cours a globalement bien ete compris. Maintenant on se sort le poil dans la main et la prochaine fois, essayez de faire mieux et davantage, ce sera d'autant plus formateur pour vous.
