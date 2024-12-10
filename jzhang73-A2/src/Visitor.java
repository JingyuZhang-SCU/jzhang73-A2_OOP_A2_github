public class Visitor extends Person {
    private String membershipId;
    private String ticketType;

    public Visitor() {
        super();
    }

    public Visitor(String name, int age, String id, String membershipId, String ticketType) {
        super(name, age, id);
        this.membershipId = membershipId;
        this.ticketType = ticketType;
    }


    public String getMembershipId() { return membershipId; }
    public void setMembershipId(String membershipId) { this.membershipId = membershipId; }
    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }
}