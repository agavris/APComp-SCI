package AdvancedJavaProjects;

public class LunchLine {
    private String first;
    private LunchLine rest;

    public LunchLine() {
        this.first = "Default Student";
        this.rest = null;
    }
    public LunchLine(String leader, LunchLine allElse) {
        this.first = leader;
        this.rest = allElse;
    }


    public void printLineMembers() {
        System.out.println(this.first);
        if (this.rest != null) {
            this.rest.printLineMembers();
        }
    }
    public int countLineLength() {
        if (this.rest == null) {
            return 1;
        } else {
            return 1 + this.rest.countLineLength();
        }
    }
    public void addToFront(String addme) {
        this.rest = new LunchLine(this.first, this.rest);
        this.first = addme;
    }
    public void removeFront() {
        if (this.rest != null) {
            this.first = this.rest.first;
            this.rest = this.rest.rest;
        }

    }
    public void addToBack(String addme) {
        if (this.rest == null) {
            this.rest = new LunchLine(addme, null);
        } else {
            this.rest.addToBack(addme);
        }


    }
    public void cutInLine(String addme, String aheadOf) {
        if (this.first.equals(aheadOf)) {
            this.addToFront(addme);
        } else {
            this.rest.cutInLine(addme, aheadOf);
        }

    }
    public void mergeLines(LunchLine other) {
        if (this.rest == null) {
            this.rest = other;
        } else {
            this.rest.mergeLines(other);
        }
    }
}