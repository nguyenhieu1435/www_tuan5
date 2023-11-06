package vn.edu.iuh.fit.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.backend.enums.SkillType;

@Converter(autoApply = true)
public class SkillTypeConverter implements AttributeConverter<SkillType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SkillType attribute) {
        return attribute.getNumValue();
    }

    @Override
    public SkillType convertToEntityAttribute(Integer dbData) {
        return SkillType.getSkillType(dbData);
    }
}
