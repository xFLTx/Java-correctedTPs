public interface IGestionnaireVoyage {
    void reserverVoyage(Voyage voyage) throws VoyageDejaReserveException;
    void afficherVoyagesReserves();
    void supprimerVoyageReserve(Voyage v) throws VoyageNonTrouveException;
}
