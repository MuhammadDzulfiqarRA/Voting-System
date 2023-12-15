package voting;

public class User {
   private String nik;
   private String nama;
   private int umur;
   private int voteNumber;
   
   User(String nik, String nama, int umur){
      this.nik = nik;
      this.nama = nama;
      this.umur = umur;
      voteNumber = 0;
   }
   
   public String getNik() {
      return nik;
   }
   
   public void setNik(String nik) {
      this.nik = nik;
   }
   
   public String getNama() {
      return nama;
   }
   
   public void setNama(String nama) {
      this.nama = nama;
   }
   
   public int getUmur() {
      return umur;
   }
   
   public void setUmur(int umur) {
      this.umur = umur;
   }
   
   public int getVoteNumber() {
      return voteNumber;
   }
   
   public void setVoteNumber(int vote){
      this.voteNumber = vote;
   }
   
}
