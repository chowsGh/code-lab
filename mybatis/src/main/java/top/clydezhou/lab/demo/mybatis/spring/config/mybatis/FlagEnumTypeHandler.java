package top.clydezhou.lab.demo.mybatis.spring.config.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import top.clydezhou.lab.demo.mybatis.spring.entity.Flag;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author clyde
 * @date 2020-08-09 23:16
 */
public class FlagEnumTypeHandler extends BaseTypeHandler<Flag> {

    private final Map<Integer, Flag> enums = new HashMap<>();

    public FlagEnumTypeHandler() {
        Flag[] values = Flag.values();
        for (Flag value : values) {
            enums.put(value.getCode(), value);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Flag parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public Flag getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int ordinal = rs.getInt(columnName);
        if (ordinal == 0 && rs.wasNull()) {
            return null;
        }
        return toOrdinalEnum(ordinal);
    }

    @Override
    public Flag getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int ordinal = rs.getInt(columnIndex);
        if (ordinal == 0 && rs.wasNull()) {
            return null;
        }
        return toOrdinalEnum(ordinal);
    }

    @Override
    public Flag getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int ordinal = cs.getInt(columnIndex);
        if (ordinal == 0 && cs.wasNull()) {
            return null;
        }
        return toOrdinalEnum(ordinal);
    }

    private Flag toOrdinalEnum(int ordinal) {
        return enums.get(ordinal);
    }
}
