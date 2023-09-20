package com.chris.accountservice.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "FIGHTER")
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIGHTER_NAME", length = 100)
    private String fighterName;
    @Column(name = "NICK_NAME", length = 100)
    private String nickname;
    @Column(name = "NATIONALITY", length = 50)
    private String nationality;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;
    @Column(name = "HEIGHT", length = 10)
    private String height;
    @Column(name = "WEIGHT", length = 10)
    private String weight;
    @Column(name = "ASSOCIATION", length = 100)
    private String association;
    @Column(name = "KO_TKO_WIN")
    private int koTkoWin;
    @Column(name = "KO_TKO_WIN_PERCENTAGE")
    private double koTkoWinPercentage;
    @Column(name = "SUBMISSION_WIN")
    private int submissionWin;
    @Column(name = "SUBMISSION_WIN_PERCENTAGE")
    private double submissionWinPercentage;
    @Column(name = "DECISION_WIN")
    private int decisionWin;
    @Column(name = "DECISION_WIN_PERCENTAGE")
    private double decisionWinPercentage;
    @Column(name = "KO_TKO_LOSS")
    private int koTkoLoss;
    @Column(name = "KO_TKO_LOSS_PERCENTAGE")
    private double koTkoLossPercentage;
    @Column(name = "SUBMISSION_LOSS")
    private int submissionLoss;
    @Column(name = "SUBMISSION_LOSS_PERCENTAGE")
    private double submissionLossPercentage;
    @Column(name = "DECISION_LOSS")
    private int decisionLoss;
    @Column(name = "DECISION_LOSS_PERCENTAGE")
    private double decisionLossPercentage;
    @Column(name = "DRAWS")
    private int draws;
    @Column(name = "NO_CONTEST")
    private int noContest;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt; // Add created_at property

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt; // Add updated_at property

    @Column(name = "PROFILE_IMAGE_URL")
    private String profileImageUrl;

    // Private constructor to prevent direct instantiation
    private Fighter() {
    }

    public static class Builder {
        private Fighter fighter = new Fighter();

        public Builder setFighterName(String fighterName) {
            fighter.fighterName = fighterName;
            return this;
        }

        public Builder setNickname(String nickname) {
            fighter.nickname = nickname;
            return this;
        }

        public Builder setNationality(String nationality) {
            fighter.nationality = nationality;
            return this;
        }

        public Builder setBirthDate(LocalDate birthDate) {
            fighter.birthDate = birthDate;
            return this;
        }

        public Builder setHeight(String height) {
            fighter.height = height;
            return this;
        }

        public Builder setWeight(String weight) {
            fighter.weight = weight;
            return this;
        }

        public Builder setAssociation(String association) {
            fighter.association = association;
            return this;
        }

        public Builder setKoTkoWin(int koTkoWin) {
            fighter.koTkoWin = koTkoWin;
            return this;
        }

        public Builder setKoTkoWinPercentage(double koTkoWinPercentage) {
            fighter.koTkoWinPercentage = koTkoWinPercentage;
            return this;
        }

        public Builder setSubmissionWin(int submissionWin) {
            fighter.submissionWin = submissionWin;
            return this;
        }

        public Builder setSubmissionWinPercentage(double submissionWinPercentage) {
            fighter.submissionWinPercentage = submissionWinPercentage;
            return this;
        }

        public Builder setDecisionWin(int decisionWin) {
            fighter.decisionWin = decisionWin;
            return this;
        }

        public Builder setDecisionWinPercentage(double decisionWinPercentage) {
            fighter.decisionWinPercentage = decisionWinPercentage;
            return this;
        }

        public Builder setKoTkoLoss(int koTkoLoss) {
            fighter.koTkoLoss = koTkoLoss;
            return this;
        }

        public Builder setKoTkoLossPercentage(double koTkoLossPercentage) {
            fighter.koTkoLossPercentage = koTkoLossPercentage;
            return this;
        }

        public Builder setSubmissionLoss(int submissionLoss) {
            fighter.submissionLoss = submissionLoss;
            return this;
        }

        public Builder setSubmissionLossPercentage(double submissionLossPercentage) {
            fighter.submissionLossPercentage = submissionLossPercentage;
            return this;
        }

        public Builder setDecisionLoss(int decisionLoss) {
            fighter.decisionLoss = decisionLoss;
            return this;
        }

        public Builder setDecisionLossPercentage(double decisionLossPercentage) {
            fighter.decisionLossPercentage = decisionLossPercentage;
            return this;
        }

        public Builder setDraws(int draws) {
            fighter.draws = draws;
            return this;
        }

        public Builder setNoContest(int noContest) {
            fighter.noContest = noContest;
            return this;
        }

        public Builder setprofileImageUrl(String profileImageUrl) {
            fighter.profileImageUrl = profileImageUrl;
            return this;
        }


        public Fighter build() {
            return fighter;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFighterName() {
        return fighterName;
    }

    public void setFighterName(String fighterName) {
        this.fighterName = fighterName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public int getKoTkoWin() {
        return koTkoWin;
    }

    public void setKoTkoWin(int koTkoWin) {
        this.koTkoWin = koTkoWin;
    }

    public double getKoTkoWinPercentage() {
        return koTkoWinPercentage;
    }

    public void setKoTkoWinPercentage(double koTkoWinPercentage) {
        this.koTkoWinPercentage = koTkoWinPercentage;
    }

    public int getSubmissionWin() {
        return submissionWin;
    }

    public void setSubmissionWin(int submissionWin) {
        this.submissionWin = submissionWin;
    }

    public double getSubmissionWinPercentage() {
        return submissionWinPercentage;
    }

    public void setSubmissionWinPercentage(double submissionWinPercentage) {
        this.submissionWinPercentage = submissionWinPercentage;
    }

    public int getDecisionWin() {
        return decisionWin;
    }

    public void setDecisionWin(int decisionWin) {
        this.decisionWin = decisionWin;
    }

    public double getDecisionWinPercentage() {
        return decisionWinPercentage;
    }

    public void setDecisionWinPercentage(double decisionWinPercentage) {
        this.decisionWinPercentage = decisionWinPercentage;
    }

    public int getKoTkoLoss() {
        return koTkoLoss;
    }

    public void setKoTkoLoss(int koTkoLoss) {
        this.koTkoLoss = koTkoLoss;
    }

    public double getKoTkoLossPercentage() {
        return koTkoLossPercentage;
    }

    public void setKoTkoLossPercentage(double koTkoLossPercentage) {
        this.koTkoLossPercentage = koTkoLossPercentage;
    }

    public int getSubmissionLoss() {
        return submissionLoss;
    }

    public void setSubmissionLoss(int submissionLoss) {
        this.submissionLoss = submissionLoss;
    }

    public double getSubmissionLossPercentage() {
        return submissionLossPercentage;
    }

    public void setSubmissionLossPercentage(double submissionLossPercentage) {
        this.submissionLossPercentage = submissionLossPercentage;
    }

    public int getDecisionLoss() {
        return decisionLoss;
    }

    public void setDecisionLoss(int decisionLoss) {
        this.decisionLoss = decisionLoss;
    }

    public double getDecisionLossPercentage() {
        return decisionLossPercentage;
    }

    public void setDecisionLossPercentage(double decisionLossPercentage) {
        this.decisionLossPercentage = decisionLossPercentage;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getNoContest() {
        return noContest;
    }

    public void setNoContest(int noContest) {
        this.noContest = noContest;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "id=" + id +
                ", fighterName='" + fighterName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate=" + birthDate +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", association='" + association + '\'' +
                ", koTkoWin=" + koTkoWin +
                ", koTkoWinPercentage=" + koTkoWinPercentage +
                ", submissionWin=" + submissionWin +
                ", submissionWinPercentage=" + submissionWinPercentage +
                ", decisionWin=" + decisionWin +
                ", decisionWinPercentage=" + decisionWinPercentage +
                ", koTkoLoss=" + koTkoLoss +
                ", koTkoLossPercentage=" + koTkoLossPercentage +
                ", submissionLoss=" + submissionLoss +
                ", submissionLossPercentage=" + submissionLossPercentage +
                ", decisionLoss=" + decisionLoss +
                ", decisionLossPercentage=" + decisionLossPercentage +
                ", draws=" + draws +
                ", noContest=" + noContest +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", profileImageUrl=" + profileImageUrl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fighter fighter = (Fighter) o;
        return koTkoWin == fighter.koTkoWin && Double.compare(koTkoWinPercentage, fighter.koTkoWinPercentage) == 0
                && submissionWin == fighter.submissionWin && Double.compare(submissionWinPercentage, fighter.submissionWinPercentage) == 0
                && decisionWin == fighter.decisionWin && Double.compare(decisionWinPercentage, fighter.decisionWinPercentage) == 0
                && koTkoLoss == fighter.koTkoLoss && Double.compare(koTkoLossPercentage, fighter.koTkoLossPercentage) == 0
                && submissionLoss == fighter.submissionLoss && Double.compare(submissionLossPercentage, fighter.submissionLossPercentage) == 0
                && decisionLoss == fighter.decisionLoss && Double.compare(decisionLossPercentage, fighter.decisionLossPercentage) == 0
                && draws == fighter.draws && noContest == fighter.noContest && Objects.equals(id, fighter.id)
                && Objects.equals(fighterName, fighter.fighterName) && Objects.equals(nickname, fighter.nickname)
                && Objects.equals(nationality, fighter.nationality) && Objects.equals(birthDate, fighter.birthDate)
                && Objects.equals(height, fighter.height) && Objects.equals(weight, fighter.weight)
                && Objects.equals(association, fighter.association) && Objects.equals(createdAt, fighter.createdAt)
                && Objects.equals(updatedAt, fighter.updatedAt) && Objects.equals(profileImageUrl, fighter.profileImageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fighterName, nickname, nationality, birthDate, height, weight, association, koTkoWin, koTkoWinPercentage, submissionWin, submissionWinPercentage, decisionWin, decisionWinPercentage, koTkoLoss, koTkoLossPercentage, submissionLoss, submissionLossPercentage, decisionLoss, decisionLossPercentage, draws, noContest, createdAt, updatedAt, profileImageUrl);
    }
}
