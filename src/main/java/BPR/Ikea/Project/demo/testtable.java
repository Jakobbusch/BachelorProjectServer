package BPR.Ikea.Project.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testtable")
public class testtable {
    @Id
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "varTest")
    public String varTest;

    @Column(name = "intTest")
    public int intTest;

    public testtable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public testtable(String varTest, int intTest){
        this.varTest = varTest;
        this.intTest = intTest;
    }

    public String getVarTest() {
        return varTest;
    }

    public void setVarTest(String varTest) {
        this.varTest = varTest;
    }

    public int getIntTest() {
        return intTest;
    }

    public void setIntTest(int intTest) {
        this.intTest = intTest;
    }
}
