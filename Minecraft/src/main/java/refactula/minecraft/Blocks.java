package refactula.minecraft;

public enum Blocks implements Block {

    BEDROCK {
        @Override
        public boolean isSolid() {
            return true;
        }
    },

    DIRT {
        @Override
        public boolean isSolid() {
            return true;
        }
    },

    GRASS {
        @Override
        public boolean isSolid() {
            return true;
        }
    },

    AIR {
        @Override
        public boolean isSolid() {
            return false;
        }
    },

}
