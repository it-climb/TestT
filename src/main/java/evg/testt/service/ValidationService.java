package evg.testt.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {

        private Matcher m;
        private Pattern patternName;
        private Pattern patternSurname;
        private Pattern patternPatronymic;
        private Pattern patternEmail;
        private Pattern patternBirthday;
        private Pattern patternTelephone;
        private Pattern patternPosition;
        private Pattern patternProject;
        private Pattern patternRegistration;

        public ValidationService(){
            Masks();
        }

        private void Masks(){

            this.patternName = Pattern.compile("[a-zA-z]{2,20}+");
            this.patternSurname = Pattern.compile("[a-zA-z]{2,20}+");
            this.patternPatronymic = Pattern.compile("[a-zA-z]{2,20}+");
            this.patternEmail = Pattern.compile("[^@]+@[^@\\.]+\\.[^@]+");
            this.patternBirthday = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
            this.patternTelephone = Pattern.compile("[0-9]{10,11}+");
            this.patternPosition = Pattern.compile("[a-zA-z]{2,20}+");
            this.patternProject = Pattern.compile("[a-zA-z0-9]{2,30}+");
            this.patternRegistration = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");

        }

        public boolean getNameMatch(String name){
            m = patternName.matcher(name);
            return m.matches();
        }

        public boolean getSurnameMatch(String surname){
            m = patternSurname.matcher(surname);
            return m.matches();
        }

        public boolean getPatronymicMatch(String patronymic){
            m = patternPatronymic.matcher(patronymic);
            return m.matches();
        }

        public boolean getEmailMatch(String email){
            m = patternEmail.matcher(email);
            return m.matches();
        }

        public boolean getBirthdayMatch(String birthday){
            m = patternBirthday.matcher(birthday);
            return m.matches();
        }

        public boolean getTelephoneMatch(String telephone){
            m = patternTelephone.matcher(telephone);
            return m.matches();
        }

        public boolean getPositionMatch(String position){
            m = patternPosition.matcher(position);
            return m.matches();
        }

        public boolean getProjectMatch(String project){
            m = patternProject.matcher(project);
            return m.matches();
        }

        public boolean getRegistrationMatch(String registration){
            m = patternRegistration.matcher(registration);
            return m.matches();
        }
}