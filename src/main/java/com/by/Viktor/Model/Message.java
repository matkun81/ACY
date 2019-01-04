package com.by.Viktor.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;

        private String name;

        private String email;

        private String numberPhone;

        private String themeQwest;

        private String Qwest;

        public Message(String name, String email, String numberPhone, String themeQwest, String qwest) {
            this.name = name;
            this.email = email;
            this.numberPhone = numberPhone;
            this.themeQwest = themeQwest;
            this.Qwest = qwest;
        }

        public Message() {
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNumberPhone() {
            return numberPhone;
        }

        public void setNumberPhone(String numberPhone) {
            this.numberPhone = numberPhone;
        }

        public String getThemeQwest() {
            return themeQwest;
        }

        public void setThemeQwest(String themeQwest) {
            this.themeQwest = themeQwest;
        }

        public String getQwest() {
            return Qwest;
        }

        public void setQwest(String qwest) {
            Qwest = qwest;
        }
}
