package by.kolesnik.course.students.dto;

public class TransferStudentRequest {

    private Long studentId;
    private Integer fromNumber;
    private Integer toNumber;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(Integer fromNumber) {
        this.fromNumber = fromNumber;
    }

    public Integer getToNumber() {
        return toNumber;
    }

    public void setToNumber(Integer toNumber) {
        this.toNumber = toNumber;
    }
}
