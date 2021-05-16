package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Magasin {
    float totalCommandes;
    HashMap<Client, ArrayList<Commande>> commandes = new HashMap<>();
    ArrayList<Commande> listeCommandes = new ArrayList<>();


    public Magasin() {

    }

    public void ajoutCommande(Client client, Commande commande) {
        listeCommandes.add(commande);
        commandes.put(client, listeCommandes);

    }

    public float totalDepense(Client client) {

        if (commandes.get(client) != null) {
            for (int i = 0; i < commandes.get(client).size(); i++) {
                float prix = 0;
                for (int y = 0; y < commandes.get(client).get(i).Produits.size(); y++) {
                    float prixHt = commandes.get(client).get(i).Produits.get(y).getPrixHT();
                    float tvA = commandes.get(client).get(i).Produits.get(y).gettVA();
                    float prixProduit = prixHt + ((prixHt * tvA) / 100);
                    prix += prixProduit;
                }
                totalCommandes += prix;
            }
            return totalCommandes;
        } else {
            totalCommandes = 0;
        }
        return totalCommandes;
    }

    public int chocoMiamMiam(Client client) {
        int nbrChoco = 0;
        if (commandes.get(client) != null) {
            for (int i = 0; i < commandes.get(client).size(); i++) {

                ArrayList<Produit> choco = commandes.get(client).get(i).Produits
                        .stream().filter(p -> p.getNom().startsWith("chocolat"))
                        .collect(Collectors.toCollection(ArrayList::new));

                nbrChoco += choco.size();
            }
            return nbrChoco;
        } else {
            nbrChoco = 0;
        }
        return nbrChoco;
    }
}
