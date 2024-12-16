/*
  枚举票务类型。
 */
enum TicketType {
    SEASON_PASS,
    ONE_DAY_PASS,
    WEEKEND_PASS
}

/*
  枚举会员类型。
 */
enum MembershipType {
    VIP,
    REGULAR
}

/*
  游客类，继承自Person，增加会员类型和票务类型。
 */
public class Visitor extends Person {
    private MembershipType membershipType;
    private TicketType ticketType;

    public Visitor() {
        super();
    }

    public Visitor(String name, int age, String id, MembershipType membershipType, TicketType ticketType) {
        super(name, age, id);
        this.membershipType = membershipType;
        this.ticketType = ticketType;
    }

    // Getter 和 Setter
    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
}
