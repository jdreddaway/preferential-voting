package org.prefvoting.spi.v1.elections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.prefvoting.Constants;
import org.prefvoting.spi.BaseApi;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.appengine.api.users.User;
import com.google.appengine.api.utils.SystemProperty;

@Api(
		name = "pv",
		title = "Preferential Voting",
		canonicalName = "PreferentialVoting",
		version = "v1",
		description = "API for managing elections and voting."
)
public class Elections {
	
	@Inject SampleDependency dependency;
	
	@ApiMethod(
		name = "elections.get",
		httpMethod = HttpMethod.GET
	)
	public ElectionBean get(ServletContext context) {
		BaseApi.getComponentFromContext(context).inject(this);
		ElectionBean ret =  new ElectionBean();
		ret.test = dependency.getString();
		return ret;
	}
	
	@ApiMethod(
		name = "elections.post",
		httpMethod = HttpMethod.POST
	)
	public ElectionBean post(ServletContext context, User user, ElectionBean input) {
		BaseApi.getComponentFromContext(context).inject(this);
		input.test = user.getNickname();
		String url;
		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//			Class.forName("com.mysql.jdbc.GoogleDriver");
//	        url = "jdbc:google:mysql://your-project-id:your-instance-name/guestbook?user=root";
			throw new RuntimeException("I haven't set the production database up yet!");
		} else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			url = "jdbc:mysql://127.0.0.1:3306/" + Constants.DB_NAME;
		}
		
		// TODO manage connections using connection pooling
		try (Connection conn = DriverManager.getConnection(
				url, Constants.DEV_DB_USERNAME, Constants.DEV_DB_PASSWORD)) {
			String statement = "INSERT INTO elections (title) VALUES (?)";
			PreparedStatement stmt = conn.prepareStatement(statement);
			stmt.setString(1, input.test);
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected != 1) {
				throw new RuntimeException("Write failed!");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Cannot connect to database!", e);
		}
		return input;
	}
}