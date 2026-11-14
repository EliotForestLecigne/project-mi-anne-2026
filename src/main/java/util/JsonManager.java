package util;

import action.IAction;
import action.ISpell;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entity.Stat;
import util.json.IActionAdapter;
import util.json.StatAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/// Manage the lecture and writing of the json using Gson
public class JsonManager<T> {
        private final Gson gson;
        private final Type listType;

        public JsonManager(Class<T> elementClass) {
            this.listType = TypeToken.getParameterized(List.class, elementClass).getType();
            GsonBuilder builder = new GsonBuilder().setPrettyPrinting();

            builder.registerTypeAdapter(IAction.class, new IActionAdapter());
            builder.registerTypeAdapter(Stat.class, new StatAdapter());

            this.gson = builder.create();
        }

        public List<T> readAll(String path) {
            return readListOrEmpty(new File(path));
        }

        public void append(String path, T element) {
            File file = new File(path);
            List<T> list = readListOrEmpty(file);
            list.add(element);
            writeListAtomically(file, list);
        }

        public void replace(String path, T element, Predicate<T> predicate) {
            File file = new File(path);
            List<T> list = readListOrEmpty(file);
            list.removeIf(predicate);
            list.add(element);
            writeListAtomically(file, list);
        }

        public void overwriteWithList(String path, List<T> elements) {
            writeListAtomically(new File(path), new ArrayList<>(elements));
        }

        public void overwriteWithSingle(String path, T element) {
            List<T> list = new ArrayList<>();
            list.add(element);
            writeListAtomically(new File(path), list);
        }

        private List<T> readListOrEmpty(File file) {
            if (!file.exists())
                return new ArrayList<>();

            try (BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
                List<T> list = gson.fromJson(reader, listType);
                return (list != null) ? list : new ArrayList<>();
            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }

        private void writeListAtomically(File file, List<T> elements) {
            try {
                File parent = file.getAbsoluteFile().getParentFile();
                if (parent != null && !parent.exists()) {
                    Files.createDirectories(parent.toPath());
                }

                File tmp = new File(parent, file.getName() + ".tmp");
                Files.writeString(tmp.toPath(), gson.toJson(elements, listType), StandardCharsets.UTF_8);

                try {
                    Files.move(tmp.toPath(), file.toPath(),
                            StandardCopyOption.REPLACE_EXISTING,
                            StandardCopyOption.ATOMIC_MOVE);
                } catch (AtomicMoveNotSupportedException ex) {
                    Files.move(tmp.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

