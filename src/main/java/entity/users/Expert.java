package entity.users;

import entity.business.Wallet;
import entity.business.WorkSuggestion;
import entity.enumration.Confirmation;
import entity.enumration.TypeUser;
import entity.business.SubDuty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Expert extends User {

    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;

    @Enumerated(EnumType.STRING)
    private Confirmation confirmation;

    private byte[] image;

    @ManyToMany
    @JoinTable(name = "expert_subduty")
    private Set<SubDuty> subDuties;

    @OneToMany(mappedBy = "expert")
    private List<WorkSuggestion> workSuggestions;

    @OneToOne(cascade = CascadeType.ALL)
    private Wallet wallet;

    public void setImage(byte[] image) {
        if (image.length > 300 * 1024) {
            throw new IllegalArgumentException("Image size exceeds the limit of 300KB.");
        }
        this.image = image;
    }
}
