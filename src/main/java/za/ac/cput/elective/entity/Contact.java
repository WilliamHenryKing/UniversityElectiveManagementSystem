package za.ac.cput.elective.entity;

public class Contact {

    private String emailAdd;
    private String cellNo;
    private String telNo;

    private Contact(Builder builder) {
        this.emailAdd = builder.emailAdd;
        this.cellNo = builder.cellNo;
        this.telNo = builder.telNo;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public String getCellNo() {
        return cellNo;
    }

    public String getTelNo() {
        return telNo;
    }

    public static class Builder {
        private String emailAdd, cellNo, telNo;

        public Builder setEmailAdd(String emailAdd) {
            this.emailAdd = emailAdd;
            return this;
        }

        public Builder setCellNo(String cellNo) {
            this.cellNo = cellNo;
            return this;
        }

        public Builder setTelNo(String telNo) {
            this.telNo = telNo;
            return this;
        }

        public Builder copy(Contact contact) {
            this.emailAdd = contact.emailAdd;
            this.cellNo = contact.cellNo;
            this.telNo = contact.telNo;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }

    @Override
    public String toString() {
        return "Contact:" +
                "\nEmail: '" + emailAdd +
                "\nCellphone Number: '" + cellNo +
                "\nTelephone Number: '" + telNo;
    }
}
