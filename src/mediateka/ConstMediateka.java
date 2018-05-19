package mediateka;

import java.nio.file.Paths;

public interface ConstMediateka {

	String CURRENT_DIRECTORY = new String(Paths.get(".").toAbsolutePath().normalize().toString());
	
}
