package com.company.customerdataservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
    @Entity
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Table(name="customer")
    public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private String company;
        private String phone;
        private String address1;
        private String address2;
        private String city;
        private String state;
        private int postalCode;
        private String country;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(int postalCode) {
            this.postalCode = postalCode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Customer)) return false;
            Customer customer = (Customer) o;
            return Objects.equals(getId(), customer.getId()) &&
                    Objects.equals(getFirstName(), customer.getFirstName()) &&
                    Objects.equals(getLastName(), customer.getLastName()) &&
                    Objects.equals(getCompany(), customer.getCompany()) &&
                    Objects.equals(getPhone(), customer.getPhone());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getFirstName(), getLastName(), getCompany(), getPhone());
        }
    }
