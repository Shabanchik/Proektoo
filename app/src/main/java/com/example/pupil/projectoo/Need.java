package com.example.pupil.projectoo;

public class Need {

    private String name;
    private String surName;
    private String text;
    public Need(String text, String name, String surName){
      this.setText(text);
       this.setName(name);
       this.setSurName(surName);
    }

     public String getName() {
            return name;
        }
     public void setName(String name) {
      this.name = name;
      }
      public String getText() {
            return text;
        }
      public void setText(String type) {
            this.text = text;
        }
      public String getSurName() {
            return surName;
        }
      public void setSurName(String name) {
            this.surName = surName;
        }

}
