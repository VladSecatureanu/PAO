package Models;
import java.util.Date;
import java.util.Objects;

public class Asistenta extends Angajat {

        private Integer sectie;
        private String medic;

        public Asistenta(String id, String password, String nume, String prenume, Integer salary, Integer sectie, String medic) {
            super(id, password, nume, prenume, salary);
            this.sectie = sectie;
            this.medic = medic;
        }

        public Asistenta(String nume, String prenume, Integer salary, Integer sectie, String medic) {
            super(nume, prenume , salary);
            this.sectie = sectie;
            this.medic = medic;
        }



        public Integer getSectie() {
            return sectie;
        }

        public void setSectie(Integer sectie) {
            this.sectie = sectie;
        }

        public String getMedic() {
            return medic;
        }

        public void setMedic(String medic) {
            this.medic = medic;
        }

        @Override
        public void afisareInfo() {

            super.afisareInfo();
            System.out.print("Pe sectia: " + sectie);
            if(medic != null) {
                System.out.print("Cu medic-sef: " + medic);
            }
        }

        @Override
        public String returnareInfo() {

            StringBuilder aux = new StringBuilder();
            aux.append(super.returnareInfo());
            aux.append(sectie + " ");
            aux.append(medic + " \n");

            return aux.toString();
        }



    @Override
        public boolean equals(Object ob) {
            if (this == ob) return true;
            if (ob == null || getClass() != ob.getClass()) return false;
            if (!super.equals(ob)) return false;
            Asistenta asistenta = (Asistenta) ob;
            return sectie.equals(asistenta.sectie) &&
                    medic.equals(asistenta.medic);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), sectie, medic);
        }

    }
