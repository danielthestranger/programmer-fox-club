package com.greenfoxacademy.programmerfoxclub.models;

public enum Drink {
    NONE {
        @Override
        public String toString() {
            return "Nothing";
        }
    },
    LEMONADE {
        @Override
        public String toString() {
            return "Lemonade";
        }
    },
    BEER {
        @Override
        public String toString() {
            return "Beer";
        }
    }
}
