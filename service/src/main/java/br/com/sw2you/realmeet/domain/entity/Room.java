package br.com.sw2you.realmeet.domain.entity;
import javax.persistence.*;
import static java.util.Objects.isNull;
import java.util.Objects;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "seats", nullable = false)
    private Integer seats;
    @Column(name = "active", nullable = false)
    private Boolean active;

    public Room(){}

    private Room(Long id, String name, Integer seats, Boolean active) {
        this.id = id;
        this.name = name;
        this.seats = seats;
        this.active = active;
    }

    //Se o campo active estiver nulo, ele irá marcar como ativo.
    @PrePersist
    public void prePersist(){
        if(isNull((active))){
            active = true;
        }
    }

    public Long getId(Long id) {
        return this.id;
    }

    public String getName(String name) {
        return this.name;
    }

    public Integer getSeats(Integer seats) {
        return this.seats;
    }

    public void getActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) &&
                Objects.equals(name, room.name) &&
                Objects.equals(seats, room.seats) &&
                Objects.equals(active, room.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, seats, active);
    }

    @Override
    public String toString() {
        return
                "Room{" +
                "id=" +
                id +
                ", name='" +
                name +
                        '\'' +
                ", seats=" +
                seats +
                ", active=" +
                active +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Integer seats;
        private Boolean active;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder seats(Integer seats) {
            this.seats = seats;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Room build() {
            Room room = new Room();
            room.getId(id);
            room.getName(name);
            room.getSeats(seats);
            room.getActive(active);
            return room;
        }
    }
}
