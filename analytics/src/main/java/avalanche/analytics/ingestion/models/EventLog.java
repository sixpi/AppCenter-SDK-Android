package avalanche.analytics.ingestion.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import avalanche.base.ingestion.models.InSessionLog;
import avalanche.base.ingestion.models.utils.LogUtils;

import static avalanche.base.ingestion.models.CommonProperties.ID;
import static avalanche.base.ingestion.models.CommonProperties.NAME;

/**
 * Event log.
 */
public class EventLog extends InSessionLog {

    public static final String TYPE = "event";

    /**
     * Unique identifier for this event.
     */
    private String id;

    /**
     * Name of the event.
     */
    private String name;

    @Override
    public String getType() {
        return TYPE;
    }

    /**
     * Get the id value.
     *
     * @return the id value
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set the id value.
     *
     * @param id the id value to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void read(JSONObject object) throws JSONException {
        super.read(object);
        setId(object.getString(ID));
        setName(object.getString(NAME));
    }

    @Override
    public void write(JSONStringer writer) throws JSONException {
        super.write(writer);
        writer.key(ID).value(getId());
        writer.key(NAME).value(getName());
    }

    @Override
    public void validate() throws IllegalArgumentException {
        super.validate();
        LogUtils.checkNotNull(ID, getId());
        LogUtils.checkNotNull(NAME, getName());
    }
}
