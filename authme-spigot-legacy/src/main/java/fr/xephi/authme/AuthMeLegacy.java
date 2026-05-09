package fr.xephi.authme;

import net.byteflux.libby.BukkitLibraryManager;
import net.byteflux.libby.Library;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * AuthMe main class for legacy Spigot versions (below 1.16.5).
 * This class handles library loading using Libby before initializing the core plugin.
 */
public class AuthMeLegacy extends AuthMe {

    @Override
    public void onLoad() {
        BukkitLibraryManager libraryManager = new BukkitLibraryManager(this);
        libraryManager.addMavenCentral();
        libraryManager.addRepository("https://repo.codemc.io/repository/maven-public/");
        libraryManager.addRepository("https://repo.onarandombox.com/multiverse-releases/");
        libraryManager.addRepository("https://repo.essentialsx.net/releases/");

        // Load all required libraries
        loadLibrary(libraryManager, "javax.inject", "javax.inject", "1");
        loadLibrary(libraryManager, "javax.annotation", "javax.annotation-api", "1.3.2");
        loadLibrary(libraryManager, "com.sun.activation", "javax.activation", "1.2.0");
        loadLibrary(libraryManager, "com.sun.mail", "javax.mail", "1.6.2");
        loadLibrary(libraryManager, "com.google.code.findbugs", "jsr305", "3.0.2");
        loadLibrary(libraryManager, "org.slf4j", "slf4j-api", "2.0.13");
        loadLibrary(libraryManager, "com.maxmind.db", "maxmind-db", "3.1.1");
        loadLibrary(libraryManager, "com.fasterxml.jackson.core", "jackson-annotations", "2.17.2");
        loadLibrary(libraryManager, "com.fasterxml.jackson.core", "jackson-core", "2.17.2");
        loadLibrary(libraryManager, "com.fasterxml.jackson.core", "jackson-databind", "2.17.2");

        loadLibrary(libraryManager, "ch.jalu", "injector", "1.0");
        loadLibrary(libraryManager, "net.ricecode", "string-similarity", "1.0.0");
        loadLibrary(libraryManager, "com.maxmind.geoip2", "geoip2", "4.3.0");
        loadLibrary(libraryManager, "javatar", "javatar", "2.5");
        loadLibrary(libraryManager, "org.apache.commons", "commons-email", "1.6.0");
        loadLibrary(libraryManager, "com.zaxxer", "HikariCP", "7.0.2");
        loadLibrary(libraryManager, "org.slf4j", "slf4j-simple", "2.0.13");
        loadLibrary(libraryManager, "ch.jalu", "datasourcecolumns", "0.1.2");
        loadLibrary(libraryManager, "com.mysql", "mysql-connector-j", "9.3.0");
        loadLibrary(libraryManager, "org.mariadb.jdbc", "mariadb-java-client", "3.5.7");
        loadLibrary(libraryManager, "org.postgresql", "postgresql", "42.7.7");
        loadLibrary(libraryManager, "de.rtner", "PBKDF2", "1.1.4");
        loadLibrary(libraryManager, "de.mkammerer", "argon2-jvm-nolibs", "2.12");
        loadLibrary(libraryManager, "at.favre.lib", "bcrypt", "0.10.2");
        loadLibrary(libraryManager, "com.warrenstrange", "googleauth", "1.5.0");
        loadLibrary(libraryManager, "ch.jalu", "configme", "1.3.1");
        loadLibrary(libraryManager, "org.bstats", "bstats-base", "3.1.0");
        loadLibrary(libraryManager, "org.bstats", "bstats-bukkit", "3.1.0");

        // Call super.onLoad() in case AuthMe ever implements it
        super.onLoad();
    }

    private void loadLibrary(BukkitLibraryManager libraryManager, String groupId, String artifactId, String version) {
        System.out.println("[AuthMeLegacy] Loading library " + groupId + ":" + artifactId + ":" + version);
        Library library = Library.builder()
            .groupId(groupId)
            .artifactId(artifactId)
            .version(version)
            .build();
            libraryManager.loadLibrary(library);
    }
}
