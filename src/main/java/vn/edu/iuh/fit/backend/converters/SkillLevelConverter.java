package vn.edu.iuh.fit.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
@Converter(autoApply = true)
public class SkillLevelConverter implements AttributeConverter<SkillLevel, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SkillLevel attribute) {
        return attribute.getNumValue();
    }

    @Override
    public SkillLevel convertToEntityAttribute(Integer dbData) {
        return SkillLevel.getSkillLevel(dbData);
    }
}
