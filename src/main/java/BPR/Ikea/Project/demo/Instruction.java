package BPR.Ikea.Project.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instruction")
public class Instruction {

    @Id
    @Column(name = "iD", nullable = false)
    private int iD;

    @Column(name = "stepNumber")
    private int stepNumber;

    @Column(name = "text")
    private String text;

    public Instruction() {
    }

    public Instruction(int iD, int stepNumber, String text) {
        this.iD = iD;
        this.stepNumber = stepNumber;
        this.text = text;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
