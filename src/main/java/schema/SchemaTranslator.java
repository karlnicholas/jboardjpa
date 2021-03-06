package schema;

import java.io.*;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import jboard.model.Article;
import jboard.model.ArticleComment;


public class SchemaTranslator {

	public static void main(String[] args) throws IOException {

		Class<?>[] entityClasses = {
			Article.class, 
			ArticleComment.class, 
		};

		MetadataSources metadata = new MetadataSources(new StandardServiceRegistryBuilder()
			.applySetting("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
			// .applySetting("hibernate.implicit_naming_strategy","opca.xxx.util.ImprovedImplicitNamingStrategy")
			// .applySetting("hibernate.physical_naming_strategy", "opca.ejb.util.ImprovedNamingStrategy")
			.build()
		);

		// [...] adding annotated classes to metadata here...
		for (Class<?> clazz : entityClasses)
			metadata.addAnnotatedClass(clazz);

		SchemaExport export = new SchemaExport((MetadataImplementor) metadata.buildMetadata())
			// .setHaltOnError( haltOnError )
			.setOutputFile("db-schema.sql")
			.setDelimiter(";");

		export.create(true, false);

	}

}
