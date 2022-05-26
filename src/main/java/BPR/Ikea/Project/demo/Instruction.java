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

    /**
     * empty constructor
     */
    public Instruction() {
    }

    /**
     * Main constructor Instruction
     * @param iD
     * @param stepNumber
     * @param text
     */
    public Instruction(int iD, int stepNumber, String text) {
        this.iD = iD;
        this.stepNumber = stepNumber;
        this.text = text;
    }

    /**
     * To get id
     * @return id
     */
    public int getiD() {
        return iD;
    }

    /**
     * To set the id
     * @param iD
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * To get id
     * @return id
     */
    public int getStepNumber() {
        return stepNumber;
    }

    /**
     * To set the stepNumber
     * @param stepNumber
     */
    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    /**
     * To get text
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * To set the text
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }
}
