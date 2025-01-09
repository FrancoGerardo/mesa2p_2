package com.ssvs.SSVS.backend.repository;

import com.ssvs.SSVS.backend.model.Paciente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class PacienteRepository {

    private final JdbcTemplate jdbcTemplate;

    public PacienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private RowMapper<Paciente> rowMapper = new RowMapper<Paciente>() {
        @Override
        public Paciente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Paciente paciente = new Paciente();
            paciente.setId(rs.getInt("paciente_id"));
            paciente.setUsuarioId(rs.getInt("usuario_id"));
            paciente.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
            paciente.setGenero(rs.getString("genero"));
            paciente.setTipoSangre(rs.getString("tipo_sangre"));
            paciente.setNombre(rs.getString("nombre"));   // Mapear el nombre
            paciente.setApellido(rs.getString("apellido")); // Mapear el apellido
            return paciente;
        }
    };
    

    public List<Paciente> findAll() {
        String sql = """
            SELECT p.paciente_id, p.usuario_id, p.fecha_nacimiento, p.genero, p.tipo_sangre, 
                   u.nombre, u.apellido
            FROM Pacientes p
            JOIN Usuarios u ON p.usuario_id = u.usuario_id
        """;
        return jdbcTemplate.query(sql, rowMapper);
    }
    
    public Paciente findById(int id) {
        String sql = """
            SELECT p.paciente_id, p.usuario_id, p.fecha_nacimiento, p.genero, p.tipo_sangre, 
                   u.nombre, u.apellido
            FROM Pacientes p
            JOIN Usuarios u ON p.usuario_id = u.usuario_id
            WHERE p.paciente_id = ?
        """;
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
    

    public void save(Paciente paciente) {
        String sql = "INSERT INTO Pacientes (usuario_id, fecha_nacimiento, genero, tipo_sangre) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, paciente.getUsuarioId(), paciente.getFechaNacimiento(), paciente.getGenero(), paciente.getTipoSangre());
    }

    public void update(int id, Paciente paciente) {
        String sql = "UPDATE Pacientes SET usuario_id = ?, fecha_nacimiento = ?, genero = ?, tipo_sangre = ? WHERE paciente_id = ?";
        jdbcTemplate.update(sql, paciente.getUsuarioId(), paciente.getFechaNacimiento(), paciente.getGenero(), paciente.getTipoSangre(), id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM Pacientes WHERE paciente_id = ?";
        jdbcTemplate.update(sql, id);
    }
     // Actualizar el estado del seguro de un paciente
    public void actualizarEstadoSeguro(int pacienteId, boolean seguroActivo, LocalDate fechaVencimiento) {
        String sql = "UPDATE Pacientes SET seguro_activo = ?, fecha_vencimiento_seguro = ? WHERE paciente_id = ?";
        jdbcTemplate.update(sql, seguroActivo, fechaVencimiento, pacienteId);
    }

}
