package crud1;

public class Automa implements State{
    
    CrudUIAutomabile gui;
    private State stato;

    public Automa(CrudUIAutomabile gui) {
        this.gui = gui;
        stato = new Ricerca();
    }
    
    @Override
    public void next(Event e) {
        stato.next(e);
    }

    public class Ricerca implements State{

        @Override
        public void next(Event e) {
            if (e instanceof AddEvent){
                stato = new Aggiungi();
                gui.vaiAStatoAggiungi();
            } else if (e instanceof SelezionaEvent){
                stato = new Visualizza();
                gui.vaiAStatoVisualizza();
            } else {
                System.out.println("Evento Inatteso");
            }
        }
        
    }
    
    public class Rimuovi implements State{

        @Override
        public void next(Event e) {
            if (e instanceof ConfermaEvent){
                stato = new Ricerca();
                gui.vaiAStatoRicerca();
            } else if (e instanceof AnnullaEvent){
                stato = new Visualizza();
                gui.vaiAStatoVisualizza();
            } else {
                System.out.println("Evento Inatteso");
            }
        }
    }
    
    public class Modifica implements State{

        @Override
        public void next(Event e) {
            if (e instanceof ConfermaEvent){
                stato = new Visualizza();
                gui.vaiAStatoVisualizza();
            } else if (e instanceof AnnullaEvent){
                stato = new Visualizza();
                gui.vaiAStatoVisualizza();
            } else {
                System.out.println("Evento Inatteso");
            }
        }     
    }
    
    public class Visualizza implements State{

        @Override
        public void next(Event e) {
            if (e instanceof RicercaEvent){
                stato = new Ricerca();
                gui.vaiAStatoRicerca();
            } else if (e instanceof AddEvent){
                stato = new Aggiungi();
                gui.vaiAStatoAggiungi();
            } else if (e instanceof ModificaEvent){
                stato = new Modifica();
                gui.vaiAStatoModifica();
            } else if (e instanceof RimuoviEvent){
                stato = new Rimuovi();
                gui.vaiAStatoRimuovi();
            } else if (e instanceof SelezionaEvent){
                // popola la tabella? TODO               
            } else {
                System.out.println("Evento Inatteso");
            }
        }
    }
    
    public class Aggiungi implements State{

        @Override
        public void next(Event e) {
             if (e instanceof ConfermaEvent){
                stato = new Visualizza();
                gui.vaiAStatoVisualizza();
            } else {
                System.out.println("Evento Inatteso");
            }
        }
    }
}
