public class ItemDefinition {

        private final int id;
        private final String title;

        public ItemDefinition(int id, String title) {
            this.id = id;
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return title;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ItemDefinition that = (ItemDefinition) o;
            return id == that.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
