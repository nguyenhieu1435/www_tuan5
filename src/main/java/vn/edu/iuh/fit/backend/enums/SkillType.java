package vn.edu.iuh.fit.backend.enums;

public enum SkillType {
    SOFT_SKILL(0),
    UNSPECIFIC(1),
    TECHNICAL_SKILL(2);

    private final int numValue;

    private SkillType(int numValue){
        this.numValue = numValue;
    }
    public int getNumValue(){
        return this.numValue;
    }
    public static SkillType getSkillType(int numValue){
        return switch (numValue) {
            case 0 -> SkillType.SOFT_SKILL;
            case 1 -> SkillType.UNSPECIFIC;
            case 2 -> SkillType.TECHNICAL_SKILL;
            default -> SkillType.SOFT_SKILL;
        };
    }
}
