/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import MDJ.Ficheiros;
import MDJ.Generater;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author BRAVANTIC
 */
public class HelperTreeNodes {

    public static void createChildrenJar(File fileRoot,
            DefaultMutableTreeNode node) {
        try {
            // Cria um URLClassLoader para carregar classes a partir do JAR
            URLClassLoader classLoader = new URLClassLoader(new URL[]{fileRoot.toURI().toURL()});

            // Abre o arquivo JAR
            JarFile jarFile = new JarFile(fileRoot);

            // Obtém todas as entradas (arquivos) no JAR
            Enumeration<JarEntry> entries = jarFile.entries();
            Ficheiros files = new Ficheiros();
            // Itera sobre as entradas para encontrar classes
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().endsWith(".class") && !entry.getName().contains("$")) {
                    String className = entry.getName().replace("/", ".").replace(".class", "");
                    // Carrega a classe
                    Class<?> classe = classLoader.loadClass(className);
                    if (!classe.isInterface()) {
                        Generater.transformer(classe.getDeclaredFields(), classe.getSimpleName());
                        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(entry.getName());
                        DefaultMutableTreeNode childNodes = new DefaultMutableTreeNode("");
                        node.add(childNode);
                    }

                }
            }
            files.createZipDir();
            files.deleteFiles();
            // Fecha o arquivo JAR
            jarFile.close();

        } catch (MalformedURLException ex) {
            Logger.getLogger(HelperTreeNodes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException | UnsupportedClassVersionError | SecurityException ex) {
            Logger.getLogger(HelperTreeNodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createChildrenDll(List<String> classes,
            DefaultMutableTreeNode node) {
        for (String classe : classes) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(classe);
            DefaultMutableTreeNode childNodes = new DefaultMutableTreeNode("");
            node.add(childNode);
        }

    }

}
