package br.com.vivo.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vivo.dto.DeviceDto;
import br.com.vivo.repository.DeviceRepository;

@Transactional
@Repository
public class DeviceRepositoryImp implements DeviceRepository {

	private static final Logger log = LoggerFactory.getLogger(DeviceRepositoryImp.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void initializeDeviceInformation(DeviceDto deviceDto) {

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("  INSERT INTO ");
			sql.append("  tb_device (");
			sql.append("  id, ");
			sql.append("  tb_device_temperature, ");
			sql.append("  tb_device_power_on_off, ");
			sql.append("  tb_device_scheduler_power_on, ");
			sql.append("  tb_device_scheduler_power_off, ");
			sql.append("  tb_device_power_off_active, ");
			sql.append("  tb_device_power_on_active, ");
			sql.append("  tb_device_local_temperature, ");
			sql.append("  tb_device_message) ");
			sql.append(
					"  values (:id, :tbDeviceTemperature, :tbDevicePowerOnOff, :tbDeviceSchedulerPowerOn, :tbDeviceSchedulerPowerOff, :tbDevicePowerOffActive, :tbDevicePowerOnActive, :tbDeviceLocalTemperature, :tbDeviceMessage)");
			SqlParameterSource params = new MapSqlParameterSource().addValue("id", deviceDto.getId())
					.addValue("tbDeviceTemperature", deviceDto.getTemperature())
					.addValue("tbDevicePowerOnOff", deviceDto.getPowerOnOff())
					.addValue("tbDeviceSchedulerPowerOn", deviceDto.getSchedulerPowerOn())
					.addValue("tbDeviceSchedulerPowerOff", deviceDto.getSchedulerPowerOff())
					.addValue("tbDevicePowerOffActive", deviceDto.getDevicePowerOffActive())
					.addValue("tbDevicePowerOnActive", deviceDto.getDevicePowerOnActive())
					.addValue("tbDeviceLocalTemperature", deviceDto.getLocalTemperature())
					.addValue("tbDeviceMessage", deviceDto.getDeviceMessage());
			jdbcTemplate.update(sql.toString(), params);
			log.info("AR CONDICIONADO PRONTO!");
		} catch (Exception e) {
			log.error("ERRO AO PREPARAR O AR CONDICIONADO: " + e.getMessage());
		}
	}

	@Override
	public void updateDeviceInformation(DeviceDto deviceDto) {
		deviceDto.setId(1L);
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE tb_device ");
			sql.append(" SET  ");
			sql.append(" tb_device_temperature = :tbDeviceTemperature, ");
			sql.append(" tb_device_power_on_off = :tbDevicePowerOnOff, ");
			sql.append(" tb_device_scheduler_power_on = :tbDeviceSchedulerPowerOn, ");
			sql.append(" tb_device_scheduler_power_off = :tbDeviceSchedulerPowerOff, ");
			sql.append(" tb_device_power_on_active = :tbDevicePowerOnActive, ");
			sql.append(" tb_device_power_off_active = :tbDevicePowerOffActive, ");
			sql.append(" tb_device_local_temperature = :tbDeviceLocalTemperature, ");
			sql.append(" tb_device_message = :tbDeviceMessage ");
			sql.append(" WHERE id = :id");
			SqlParameterSource params = new MapSqlParameterSource().addValue("id", deviceDto.getId())
					.addValue("tbDeviceTemperature", deviceDto.getTemperature())
					.addValue("tbDevicePowerOnOff", deviceDto.getPowerOnOff())
					.addValue("tbDeviceSchedulerPowerOn", deviceDto.getSchedulerPowerOn())
					.addValue("tbDeviceSchedulerPowerOff", deviceDto.getSchedulerPowerOff())
					.addValue("tbDevicePowerOnActive", deviceDto.getDevicePowerOnActive())
					.addValue("tbDevicePowerOffActive", deviceDto.getDevicePowerOffActive())
					.addValue("tbDeviceLocalTemperature", deviceDto.getLocalTemperature())
					.addValue("tbDeviceMessage", deviceDto.getDeviceMessage());
			jdbcTemplate.update(sql.toString(), params);
		} catch (Exception e) {
			log.error("ERRO NA ATUALIZAÇÃO DO AR CONDICIONADO: " + e.getMessage());
		}
	}

	@Override
	public void deleteTable() {

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" TRUNCATE TABLE tb_device;");
			SqlParameterSource params = new MapSqlParameterSource();
			jdbcTemplate.update(sql.toString(), params);
			log.info("INICIALIZADO!");
		} catch (Exception e) {
			log.error("ERRO AO LIMPAR A TABELA " + e.getMessage());
		}
	}

	@Override
	public DeviceDto getDeviceInformation(Long id) {

		id = 1L;

		try {
			StringBuilder sql = new StringBuilder(sqlSelectPrincipal);
			sql.append(" WHERE id = :id");
			SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
			return devolveListaObjeto(sql, params);
		} catch (Exception ex) {
			log.error("ERRO NA CONSULTA O STATUS DO AR CODICIONADO: ", ex.getMessage());
			return null;
		}

	}

	private DeviceDto devolveListaObjeto(StringBuilder sql, SqlParameterSource params) {
		return jdbcTemplate.queryForObject(sql.toString(), params, (rs, i) -> {
			DeviceDto deviceDto = new DeviceDto();
			deviceDto.setId(rs.getLong("id"));
			deviceDto.setTemperature(rs.getDouble("tb_device_temperature"));
			deviceDto.setPowerOnOff(rs.getBoolean("tb_device_power_on_off"));
			deviceDto.setSchedulerPowerOn(rs.getString("tb_device_scheduler_power_on"));
			deviceDto.setSchedulerPowerOff(rs.getString("tb_device_scheduler_power_off"));
			deviceDto.setDevicePowerOnActive(rs.getBoolean("tb_device_power_on_active"));
			deviceDto.setDevicePowerOffActive(rs.getBoolean("tb_device_power_off_active"));
			deviceDto.setLocalTemperature(rs.getDouble("tb_device_local_temperature"));
			deviceDto.setDeviceMessage(rs.getString("tb_device_message"));
			return deviceDto;
		});
	}

	final static StringBuilder sqlSelectPrincipal = new StringBuilder().append("  SELECT ").append("  id ")
			.append("  ,tb_device_temperature ").append("  ,tb_device_power_on_off ")
			.append("  ,tb_device_scheduler_power_on ").append("  ,tb_device_scheduler_power_off ")
			.append("  ,tb_device_power_on_active ").append("  ,tb_device_power_off_active ")
			.append("  ,tb_device_local_temperature ").append("  ,tb_device_message ").append("  FROM tb_device ");

}
