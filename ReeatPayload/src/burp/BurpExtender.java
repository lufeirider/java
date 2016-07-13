package burp;

import java.io.PrintWriter;

public class BurpExtender implements IBurpExtender, IIntruderPayloadGeneratorFactory, IIntruderPayloadProcessor
{
    private IExtensionHelpers helpers;
    
    // hard-coded payloads
    // [in reality, you would use an extension for something cleverer than this]
    private static final byte[][] PAYLOADS = 
    {
        "|".getBytes(),
        "<script>alert(1)</script>".getBytes(),
    };

    //
    // implement IBurpExtender
    //
    
    @Override
    public void registerExtenderCallbacks(final IBurpExtenderCallbacks callbacks)
    {
        // obtain an extension helpers object
        helpers = callbacks.getHelpers();
        
        // set our extension name
        callbacks.setExtensionName("Custom intruder payloads");
        
        // register ourselves as an Intruder payload generator
        callbacks.registerIntruderPayloadGeneratorFactory(this);
        
        // register ourselves as an Intruder payload processor
        callbacks.registerIntruderPayloadProcessor(this);
    }

    //
    // implement IIntruderPayloadGeneratorFactory
    //
    
    @Override
    public String getGeneratorName()
    {
        return "My custom payloads";
    }

    @Override
    public IIntruderPayloadGenerator createNewInstance(IIntruderAttack attack)
    {
        // return a new IIntruderPayloadGenerator to generate payloads for this attack
        return new IntruderPayloadGenerator();
    }

    //
    // implement IIntruderPayloadProcessor
    //
    
    @Override
    public String getProcessorName()
    {
        return "ReeatPayload";
    }

    @Override
    public byte[] processPayload(byte[] currentPayload, byte[] originalPayload, byte[] baseValue)
    {
        // decode the base value
        String inputString = helpers.bytesToString(baseValue);

        int i = Integer.parseInt(helpers.bytesToString(currentPayload));

        String temp = "";
        for(int x=0; x<i; x++){
        	temp = temp + inputString;
        }
        return helpers.stringToBytes(temp);
    }
    
    //
    // class to generate payloads from a simple list
    //
    
    class IntruderPayloadGenerator implements IIntruderPayloadGenerator
    {
        int payloadIndex;
        
        @Override
        public boolean hasMorePayloads()
        {
            return payloadIndex < PAYLOADS.length;
        }

        @Override
        public byte[] getNextPayload(byte[] baseValue)
        {
            byte[] payload = PAYLOADS[payloadIndex];
            payloadIndex++;
            return payload;
        }

        @Override
        public void reset()
        {
            payloadIndex = 0;
        }
    }
}