ALTER TABLE peoples
ADD COLUMN active boolean
DEFAULT TRUE
AFTER name;

