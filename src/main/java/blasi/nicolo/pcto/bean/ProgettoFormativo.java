package blasi.nicolo.pcto.bean;

public class ProgettoFormativo {

     private int id;
        private String descrizioneAttivita;
        private String dataProgetto;
        private int idTutorScolastico;
        private int idTutorAziendale;
        private int idStudente;
        private int idPctoXAzienda;
        private int idSedeTirocinio;
        private int idTutorAziendale1;
        private int idTutorAziendale2;

    
	    public ProgettoFormativo(int id, String descrizioneAttivita, String dataProgetto, 
	    		 int idTutorScolastico, int idTutorAziendale1,int idTutorAziendale2, int idStudente,                        
	                                   int idPctoXAzienda, int idSedeTirocinio) {
            this.id = id;
            this.descrizioneAttivita = descrizioneAttivita;
            this.dataProgetto = dataProgetto;
            this.idTutorScolastico = idTutorScolastico;
            this.idStudente = idStudente;
            this.idPctoXAzienda = idPctoXAzienda;
            this.idSedeTirocinio = idSedeTirocinio;
            this.idTutorAziendale1 = idTutorAziendale1;
  	        this.idTutorAziendale2 = idTutorAziendale2;
        }

        public ProgettoFormativo(int id, String descrizioneAttivita, String dataProgetto, 
            int idTutorScolastico, int idTutorAziendale, int idStudente,                        
                              int idPctoXAzienda, int idSedeTirocinio) {
            this(id, descrizioneAttivita, dataProgetto, idTutorScolastico, idTutorAziendale, 0, idStudente, idPctoXAzienda, idSedeTirocinio);

        }
    
        // Metodi getter e setter
        public int getId() {
            return id;
        }
        
        public void setId(int id) {
            this.id = id;
        }

        public String getDescrizioneAttivita() {
            return descrizioneAttivita;
        }

        public void setDescrizioneAttivita(String descrizioneAttivita) {
            this.descrizioneAttivita = descrizioneAttivita;
        }

        public String getDataProgetto() {
            return dataProgetto;
        }

        public void setDataProgetto(String dataProgetto) {
            this.dataProgetto = dataProgetto;
        }

        public int getIdTutorScolastico() {
            return idTutorScolastico;
        }

        public void setIdTutorScolastico(int idTutorScolastico) {
            this.idTutorScolastico = idTutorScolastico;
        }

        public int getIdTutorAziendale1() {
            return idTutorAziendale1;
        }

        public void setIdTutorAziendale1(int idTutorAziendale1) {
            this.idTutorAziendale1 = idTutorAziendale1;
        }

        public int getIdStudente() {
            return idStudente;
        }

        public void setIdStudente(int idStudente) {
            this.idStudente = idStudente;
        }

        public int getIdPctoXAzienda() {
            return idPctoXAzienda;
        }

        public void setIdPctoXAzienda(int idPctoXAzienda) {
            this.idPctoXAzienda = idPctoXAzienda;
        }

        public int getIdSedeTirocinio() {
            return idSedeTirocinio;
        }

        public void setIdSedeTirocinio(int idSedeTirocinio) {
            this.idSedeTirocinio = idSedeTirocinio;
        }
        
        public int getIdTutorAziendale2() {
        				return idTutorAziendale2;
        			}
        	
        	
        			public void setIdTutorAziendale2(int idTutorAziendale2) {
        				this.idTutorAziendale2 = idTutorAziendale2;
        			}

        			@Override
        			public String toString() {
        			    return id + ", " + descrizioneAttivita + ", " + dataProgetto + ", " + idTutorScolastico + ", " + idTutorAziendale 
        			           + ", " + idStudente + ", " + idPctoXAzienda + ", " + idSedeTirocinio + ", " + idTutorAziendale1 + ", " 
        			           + idTutorAziendale2;
        			}



		
        
        
}
