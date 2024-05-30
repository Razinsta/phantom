package blasi.nicolo.pcto.bean;

import java.util.Arrays;

public class DocumentoPcto {

    private int id;
    private String mailcontattoazienda; 
    private String maildatiazienda;
    private int[] convenzioneTemplate;
    private int[] pfTemplate;
    private int[] schedaValutazione;
    private int[] registroAssenze;
    private int idPcto;

        public DocumentoPcto(int id,String mailcontattoazienda,String maildatiazienda, int[] convenzioneTemplate, int[] pfTemplate, int[] schedaValutazione, int[] registroAssenze, int idPcto) {
        this.id = id;
        this.convenzioneTemplate = convenzioneTemplate;
        this.pfTemplate = pfTemplate;
        this.schedaValutazione = schedaValutazione;
        this.registroAssenze = registroAssenze;
        this.idPcto = idPcto;
        this.mailcontattoazienda= mailcontattoazienda;
        this.maildatiazienda = maildatiazienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getConvenzioneTemplate() {
        return convenzioneTemplate;
    }

    public void setConvenzioneTemplate(int[] convenzioneTemplate) {
        this.convenzioneTemplate = convenzioneTemplate;
    }

    public int[] getPfTemplate() {
        return pfTemplate;
    }

    public void setPfTemplate(int[] pfTemplate) {
        this.pfTemplate = pfTemplate;
    }

    public int[] getSchedaValutazione() {
        return schedaValutazione;
    }

    public void setSchedaValutazione(int[] schedaValutazione) {
        this.schedaValutazione = schedaValutazione;
    }

    public int[] getRegistroAssenze() {
        return registroAssenze;
    }

    public void setRegistroAssenze(int[] registroAssenze) {
        this.registroAssenze = registroAssenze;
    }

    public int getIdPcto() {
        return idPcto;
    }

    public void setIdPcto(int idPcto) {
        this.idPcto = idPcto;
    }
    
    public String getMailcontattoazienda() {
    			return mailcontattoazienda;
    		}
    	
    
    		public void setMailcontattoazienda(String mailcontattoazienda) {
    			this.mailcontattoazienda = mailcontattoazienda;
    		}
    	
    		public String getMaildatiazienda() {
    			return maildatiazienda;
    		}
    	
    		public void setMaildatiazienda(String maildatiazienda) {
    			this.maildatiazienda = maildatiazienda;
    		}

    		@Override
    		public String toString() {
    		    return id + ", " + mailcontattoazienda + ", " + maildatiazienda + ", " + Arrays.toString(convenzioneTemplate)
    		            + ", " + Arrays.toString(pfTemplate) + ", " + Arrays.toString(schedaValutazione) + ", "
    		            + Arrays.toString(registroAssenze) + ", " + idPcto;
    		}

}
