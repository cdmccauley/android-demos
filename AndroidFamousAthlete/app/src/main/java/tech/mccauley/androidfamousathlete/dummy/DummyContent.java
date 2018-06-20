package tech.mccauley.androidfamousathlete.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tech.mccauley.androidfamousathlete.R;


public class DummyContent {

    // declarations
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    // not constructor ??
    static {
        addItem(new DummyItem("0", "Introduction", R.array.intro_content, R.drawable.kaepernick, false));
        addItem(new DummyItem("1", "Bio", R.array.bio_content, false));
        addItem(new DummyItem("2", "Website", R.array.website_content, true));
    }

    // methods
    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    // class
    public static class DummyItem {

        // declarations
        public final String id;
        public final String content;
        public final int details;
        public final int image;
        public final boolean website;

        // constructors
        public DummyItem(String id, String content, int details, boolean website) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.image = 0;
            this.website = website;
        }

        public DummyItem(String id, String content, int details, int image, boolean website) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.image = image;
            this.website = website;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
