import java.util.Arrays;
import java.util.Scanner;

//ci-dessus, les trucs que java doit importer pour faire fonctionner cette chose

//pour le meilleur et pour le pire... c'est parti.......
//mais vraiment, je suis désolée pour tout ce qui va suivre....

public class MainAvecUnPuissance4Dedans {
// ici je declare toutes mes variables
// et je les déclare ici pour pouvoir y accéder de partout depuis cette Main

	private static final String joueur1 = null;
	private static final String joueur2 = null;
	static int lig = 7; // lignes du tableau
	static int col = 8; // colonnes du tableau
	static int tableau[][] = new int[lig][col]; // un très très beau tableau à 2 dimensions (soyons fous)
// String joueur1 ; // je vous laisse deviner
// String joueur2 ; // je sais, le suspens est insoutenable....
// mais en vrai, on ne les fera rentrer que plus tard
	static int tourDeJeu = 4; // pour ne pas se battre pour savoir à qui c'est de jouer
	static boolean victoire = false; // aucune idée, mais ça faisait joli ! ha si, ça me revient, c'est la condition
	static // de victoire ! (si si !!!)
// je crois n'avoir rien oublié
// sinon c'est pas grave, je reviendrai...
	String gagnant;
// je t'avais dit que je reviendrais....
	static int jeton;// les jetons des joueurs seront des "0" et des "8"
	static String notreGagnant = "nobody"; // car je ne suis pas devin
	static int choix;
	static int ligne;

// les choses sérieuses commencent ici (enfin, je crois)-----------
	public static void main(String[] args) {
// TODO Auto-generated method stub => merci l'ordi pour ton commentaire tout nul

// là je crée un machin trop classe pour pouvoir appeler les fonctions présentes
// dans la dite main
		MainAvecUnPuissance4Dedans cesttroplaclasse = new MainAvecUnPuissance4Dedans();

// on va commencer par se présenter, ça sera tout de suite plus sympa
		System.out.println("Joueur 1, quel est ton prénom ?");
// j'ai pas dit "s'il-te-plait", je sais...
		Scanner scann1 = new Scanner(System.in);
		String joueur1 = scann1.nextLine();
		System.out.println("Salut beau gosse");
		System.out.println("Et toi, c'est quoi ton petit nom ?");
		Scanner scann2 = new Scanner(System.in);
		String joueur2 = scann1.nextLine();
		System.out.println("Mouais, pas mal ton prénom...");
		System.out.println("Allez go ! " + joueur1 + " vs " + joueur2 + " !");
// et pour que les choses soient bien claires entre nous :
		System.out.println("PS : Merci de bien répondre aux questions, sinon ça plante");

//on va monter et initialiser le tableau
		for (int i = 0; i < lig; i++) {
			for (int j = 0; j < 8; j++) {
				tableau[i][j] = 1;
// pour numéroter les colonnes sur la ligne du bas
				for (int z = 0; z < 8; z++) {
					tableau[6][z] = z;
				}
				;
				;
			}
			;
		}
		;
// affichage du tableau au début du jeu :
		cesttroplaclasse.afficheLeTableau();

//----------------------------------------------------------------------
//----------------------------------------------------------------------
// ----------------------------DEBUT DU JEU ----------------------------
//----------------------------------------------------------------------
//----------------------------------------------------------------------

//=========================================================================================================
//=========================================================================================================
//=========================================================================================================
// while = niveau 1

		while (victoire != true) {

// c'est à qui de jouer svp ?
			if (tourDeJeu % 2 == 0) {
				System.out.println("\n\n      " + joueur1 + ", tu veux jouer dans quelle colonne ?");
				jeton = 0;
				gagnant = joueur1;
			} else {
				System.out.println("\n  " + joueur2 + ", dans quelle colonne veux-tu jouer ?");
				jeton = 8;
				gagnant = joueur2;
			}

			tourDeJeu++;// et hop,on incrémente en prévision du tour suivant ("ce qui est fait n'est
						// plus à faire")

// tu joues quoi ?

			Scanner scann3 = new Scanner(System.in);
			choix = scann3.nextInt();
			System.out.println(gagnant + " a joué dans la colonne " + choix);
// implémentation sur la bonne rangée dans la colonne
			ligne = 5;// on peut commencer d'écrire a partir de la ligne 5 car la 6 est réservée à la
// numérotation d
			while ((tableau[ligne][choix]) == 0 || (tableau[ligne][choix]) == 8) {
				ligne--;
			}
			;
			tableau[ligne][choix] = jeton;
			System.out.println("test ligne = " + ligne);
			cesttroplaclasse.afficheLeTableau();

			System.out.println(" \n \n  Dernier coup joué est ligne " + (ligne + 1) + " et colonne " + choix);

//=========================================================================================================
//===============================ANALYSE HORIZONTAAAAAALE==================================================
//=========================================================================================================
//analyse en cours..... (idéalement pas avant le 4ème tour de jeu pour chacun car il ne peut pas y avoir 4 pions alignés avant)
//analyse horizontale ==> condition préliminaire = s'il y a quelque chose sur la colonne 4 du dernier jeton posé

			if (tableau[ligne][4] != 1) {
				System.out.println("\n (scann horizontal en cours sur " + (ligne + 1) + "ème ligne )");

				for (int i = 1; i != 5; i++) {

					if (tableau[ligne][i] == tableau[ligne][i + 1] && tableau[ligne][i] == tableau[ligne][i + 2]
							&& tableau[ligne][i] == tableau[ligne][i + 3]) {// désolée, je suis concentrée alors j'écris
																			// moins de commentaires

						System.out.print("PUISSANCE4 !!!!!!!!!!!!!!!!!! ");
						victoire = true;
// il faut sortir de là !!!!
//cesttroplaclasse.grandeVictoire();

					}
					;

				}
				; // fin du for

			} // fin du if scann horizontal

//=========================================================================================================
//===============================ANALYSE VERTICALE=========================================================
//=========================================================================================================
// condition préliminaire : que la rangée[2][x] et la rangée[3][x] aient le même jeton
// car ces deux zones se chevauchent pour des P4 tout en haut ou tout en bas
// (j'espère que c'est à peu près clair....)

// Si la deuxième ligne a une vision
			if (tableau[2][choix] != 1) {
				// et si la troisième ligne a la même vision
				if (tableau[2][choix] == tableau[3][choix]) {// lançons donc un scann vertical
					System.out.println("Scann de la colonne en cours");

					// (si j'arrive à taper ça)
					for (int i = 0; i != 3; i++) {

						if (tableau[i][choix] == tableau[i + 1][choix]) {
							if (tableau[i][choix] == tableau[i + 2][choix]) {
								if (tableau[i][choix] == tableau[i + 3][choix]) {
									System.out.println("Victoire verticale Mec !");
								}
								;
								victoire = true;
							}
							;

						}
						;
					}
					;
				}
			}

//=========================================================================================================
//===============================ANALYSE DIAGONALE ASCENDANTE==============================================
//=========================================================================================================
// On ne peut faire qu'une diagonale qu'à partir du 5ème tour de jeu de chaque joueur,
// car il faut 10 jetons minimum pour la construire

//=========================================================================================================
//===============================ANALYSE DIAGONALE DESCENDANTE=============================================
//=========================================================================================================
// même condition prélimaniralipra qu'avant (c'est dur à écrire, ce mot)

//=========================================================================================================
//===========================================PARTIE NULLE==================================================
//=========================================================================================================
// Reviens Léon ! y'a les mêmes à la maison, et c'était pas si nul ! l'important, c'est de participer !!!

// On va à présent regarder si toutes les cases du haut ont été remplies

			if ((tableau[0][1] != 1) && (tableau[0][2] != 1) && (tableau[0][3] != 1) && (tableau[0][4] != 1)
					&& (tableau[0][5] != 1) && (tableau[0][6] != 1) && (tableau[0][7] != 1)
// je voulais faire un "for" mais j'ai pas réussi, désolée
					// et après reflexion, ça aurait été plus simple en comptant juste le nombre de tours....
			) {
				System.out.println("Ceci était une partie vraiment nulle");
				System.out.println("                        Adieu monde cruel....");
				// PAF ! sortie précipitée du programme !
				System.exit(0);
				
			}
			;


		} // fin du while initial qui est "condition de victoire" à mettre à true pour sortir de ce guêpier

//----------------------------------------------------------------------
//----------------------------------------------------------------------
//---------------------------FIN DU JEU---------------------------------
//----------------------------------------------------------------------
//----------------------------------------------------------------------

// les félicitations qui s'imposent à la sortie du grand while initial
		cesttroplaclasse.grandeVictoire();

	}// fin du main-----------------------------------------------------

// ci-dessous, des public void ....(), oui oui.... des fonctions dans des classes, ça
// s'appelle des "méthodes"

	public void afficheLeTableau() {
		System.out.println(" \n \n                ");
		for (int m = 0; m < 7; m++) {
			System.out.println("\n");
			for (int g = 1; g < 8; g++) {
				System.out.print("     " + tableau[m][g] + "    ");
			}
			;
		}
		;
	}

	public void grandeVictoire() {
		System.out.println(" \n \n                  Félicitations " + gagnant + " ! Tu as gagné !!!");

	}

}// fin de la grande classe

/*
 * Tout ça pour dire que la double barre pour faire des commentaires, c'est
 * vachement chouette, mais que ok, j'ai compris, faut pas en abuser, promis je ne le ferai plus !
 * Mais le truc, c'est que c'était tellement difficile qu'il fallait bien que je parle à quelqu'un en le faisant...
 */
