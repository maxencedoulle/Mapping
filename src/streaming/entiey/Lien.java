/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entiey;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.metamodel.SingularAttribute;
import static streaming.entiey.Lien_.version;

/**
 *
 * @author Formation
 */
@Entity
public class Lien implements Serializable {
    
    @ManyToOne
    @JoinColumn (name = "episode_id")
    private Episode episode;
    
    
    public enum Verssion {
        VF,
        VO,
        VOSTVF,
    }
    
    @Entity
    
    public enum Qualite {
       SD,
       HD,
    }
    
    @Enumerated(EnumType.STRING)
    @Column (length = 16)
    private Verssion version;
    
    @Enumerated(EnumType.STRING)
    @Column (length = 16)
    private Qualite qualite;
    
    @Column (unique = true, nullable = false)
    private String url;
    
    @ManyToOne
    @JoinColumn (name = "film_id")
    private Film film;

    public Verssion getVersion() {
        return version;
    }

    public void setVersion(Verssion version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lien)) {
            return false;
        }
        Lien other = (Lien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entiey.Lien[ id=" + id + " ]";
    }
    
}
