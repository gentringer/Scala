package chimie
import general.Graphe
import general.Sommet
import general.Arete

class Molecule extends Graphe {
  

	@Override override def addSommet(sommet: Sommet) {
		if (sommet.isInstanceOf[Atome]) {
			this.ensembleSommets.add(sommet)
			System.out.println("Ajout du sommet ok")
		}
		else {
			System.err.println("Sommet n'est pas un instance d'Atome")
		}
	}

	@Override override def addArete(arete: Arete) {
		System.out.println("add arrete dans molecule")
		if (arete.isInstanceOf[Liaison]) {
			System.out.println("arete ok")
			if (ensembleSommets.isEmpty) {
				System.err.println("Le graphe ne comporte pas de sommets")
			}
			if ((this.ensembleSommets.contains(arete.getSommet1) && this.ensembleSommets.contains(arete.getSommet2))) {
				System.out.println("L'arrete a les memes sommets que le graphe dans molecule")
				ensembleAretes.add(arete)
				arete.setGraphe(this)
			}
			else {
				System.err.println("Le graphe n'a pas les meme sommets que l'arrete dans molecule")
			}
		}
		else {
			System.err.println("Pas insnace de liaison")
		}
	}

	@Override override def createArete(sommet1: Sommet, sommet2: Sommet) {
		if (sommet1.isInstanceOf[Atome] && sommet1.isInstanceOf[Atome]) {
			if ((sommet1 != null) && (sommet2 != null)) {
				val arete: Arete = new Arete(sommet1, sommet2)
			this.addArete(arete)
			System.out.println("Arete a été créé avec succès")
			}
			else {
				System.err.println("ARete n'a pas pu être créé car un des sommets est null")
			}
		}
		else {
			System.out.println("Erreur de type")
		}
	}
}