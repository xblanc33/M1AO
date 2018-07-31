package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.type.ReferenceId;

public class ReferenceRepositoryImpl extends ConceptMapping implements ReferenceRepository {

    public ReferenceRepositoryImpl() {
        super();
    }

	@Override
	public void add(Reference reference) {
		if (reference == null) throw new ProductManagementException("cannot add null to ReferenceRepository");
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement( "INSERT INTO REFERENCE (id, name, description) VALUES (?,?,?)" );
			int nthPlaceholder = 1;
			String uuid = reference.getId().toString();			
			preparedStatement.setString( nthPlaceholder++, uuid);
			preparedStatement.setString( nthPlaceholder++, reference.getName() ); 
			preparedStatement.setString( nthPlaceholder++, reference.getDescription() ); 
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new ProductManagementException("cannot add to ReferenceRepository (SQL Exception)");
		} 
	}

	@Override
	public void remove(Reference reference) {
		//TODO
	}

	@Override
	public Reference findById(ReferenceId id) {
		if (id == null) throw new ProductManagementException("cannot find reference with null id");
		try {
			Statement statement = getConnection().createStatement();
			String query = "SELECT id, name, description FROM REFERENCE WHERE id ='"+id.toString()+"'";
			ResultSet rs = statement.executeQuery(query);
			Reference foundReference = null;
			while(rs.next()){
				//ReferenceId id = new ReferenceId(rs.getObject(0, UUID.class).toString());
				foundReference = new Reference(id, rs.getString("name"), rs.getString("description"));
			}
			rs.close();
			if (foundReference == null) throw new ProductManagementException("cannot find reference with such an id");
			else return foundReference;
		} catch (SQLException e) {
			throw new ProductManagementException("cannot find reference (SQL Exception)");
		}
	}

	@Override
	public Set<Reference> findByName(String name) {
		return null;
	}

	@Override
	public Set<Reference> getReference() {
		return null;
	}

	@Override
	public int size() {
		try {
			Statement statement = getConnection().createStatement();
			String query = "SELECT COUNT(1) FROM REFERENCE";
			ResultSet rs = statement.executeQuery(query);
			int rowCount = rs.last() ? rs.getRow() : 0; 
			rs.close();
			return rowCount;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductManagementException("cannot get size, jdbc exception");
		}
	}

}