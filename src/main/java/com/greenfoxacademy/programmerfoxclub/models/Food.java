package com.greenfoxacademy.programmerfoxclub.models;

public enum Food {
    NONE {
        @Override
        public String toString() {
            return "Nothing";
        }
    },
    PIZZA {
        @Override
        public String toString() {
            return "Pizza";
        }
    },
    RAMEN {
        @Override
        public String toString() {
            return "Ramen";
        }
    }
}
