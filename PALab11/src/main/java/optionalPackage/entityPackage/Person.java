package optionalPackage.entityPackage;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)  //this is only needed if i want to automatize the insert
    @Column(name = "id")
    private long id;

    @Column(name = "person_name")
    private String name;

    @Column(name = "no_of_friends")
    private long friendsNumber;

    @Column(name = "friends_list")
    private String friendsList;

    public Person(){

    }

    public Person(String name){
        super();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFriendsNumber() {
        return friendsNumber;
    }

    public void setFriendsNumber(long friendsNumber) {
        this.friendsNumber = friendsNumber;
    }

    public String getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(String friendsList) {
        this.friendsList = friendsList;
    }
}
