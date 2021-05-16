package com.company;


public class Main {

        public static void main (String[] args) {

                Magasin monMagasin = new Magasin();

                Produit pain = new Produit("pain", 1.00f, 5.5f);
                Produit chocolat = new Produit("chocolat", 1.50f, 19.6f);
                Produit farine = new Produit("farine", 0.50f, 5.5f);
                Produit lait = new Produit("lait", 4.00f, 5.5f);

                Produit[] tableauProduit = {pain, chocolat, farine, lait};

                //----- generation aléatoires des clients (de 3 à 5)------
                int nombreDeClientAleatoire = (int) (Math.random() * 3 + 3);

                Client[] tableauClient = new Client[nombreDeClientAleatoire];

                for (int numeroClient = 0; numeroClient < nombreDeClientAleatoire; numeroClient++) {
                        tableauClient[numeroClient] = new Client(numeroClient);
                }

                //----- generation aléatoires des commandes (de 3 à 10)-----
                int nombreDeCommandeAleatoire = (int) (Math.random() * 8 + 3);

                for (int indexCommande = 0; indexCommande < nombreDeCommandeAleatoire; indexCommande++) {
                        Commande commande = new Commande();

                        //on récupère un client au hasard dans la liste
                        Client clientAleatoire = tableauClient[(int) (Math.random() * tableauClient.length)];

                        //----- affectation aléatoire des produits de la commande  -----
                        int nombreDeProduitAleatoire = (int) (Math.random() * 5);

                        for (int indexProduitCommande = 0; indexProduitCommande < nombreDeProduitAleatoire; indexProduitCommande++) {
                                Produit produitAleatoire = tableauProduit[(int) (Math.random() * tableauProduit.length)];
                                commande.Produits.add(produitAleatoire);
                        }


                        //on ajoute dans le hashMap des commandes du magasin la commande à la clé correspondant
                        // à un client choisit aléatoirement
                        monMagasin.ajoutCommande(clientAleatoire, commande);
                }

                //on affiche la depense des clients du magasin
                for (Client client : tableauClient) {
                        if(client!=null){
                                System.out.print("Le client ayant le numero : ");
                                System.out.print(client.getNumeroClient());
                                System.out.print(" a depensé : ");
                                System.out.print(monMagasin.totalDepense(client));
                                System.out.println("€");

                                int chocoClient =monMagasin.chocoMiamMiam(client);
                                float prixTotChoco=
                                        chocoClient*(chocolat.getPrixHT()+(chocolat.getPrixHT()*chocolat.gettVA()/100));
                                float pourcentageChoco=prixTotChoco*100/ monMagasin.totalDepense(client);

                                System.out.println("Il a depensé "+pourcentageChoco +" % de son budget en chocolat");

                        }else{
                                System.out.println("Ce client a dû partir sans payer, il n'y a rien à afficher");
                        }

                }

        }
}
