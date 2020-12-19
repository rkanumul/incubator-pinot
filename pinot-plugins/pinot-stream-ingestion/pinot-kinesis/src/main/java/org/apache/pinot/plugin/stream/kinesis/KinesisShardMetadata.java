package org.apache.pinot.plugin.stream.kinesis;

import org.apache.pinot.spi.stream.v2.Checkpoint;
import org.apache.pinot.spi.stream.v2.PartitionGroupMetadata;
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorRequest;
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorResponse;
import software.amazon.awssdk.services.kinesis.model.SequenceNumberRange;
import software.amazon.awssdk.services.kinesis.model.ShardIteratorType;


public class KinesisShardMetadata extends KinesisConnectionHandler implements PartitionGroupMetadata {
  String _shardId;
  Checkpoint _startCheckpoint;
  Checkpoint _endCheckpoint;

  public KinesisShardMetadata(String shardId, String streamName, String awsRegion) {
    super(streamName, awsRegion);
    _startCheckpoint = null;
    _endCheckpoint = null;
    _shardId = shardId;
  }

  public String getShardId() {
    return _shardId;
  }

  @Override
  public Checkpoint getStartCheckpoint() {
    return _startCheckpoint;
  }

  @Override
  public Checkpoint getEndCheckpoint() {
    return _endCheckpoint;
  }

  @Override
  public void setStartCheckpoint(Checkpoint startCheckpoint) {
    _startCheckpoint = startCheckpoint;
  }

  @Override
  public void setEndCheckpoint(Checkpoint endCheckpoint) {
    _endCheckpoint = endCheckpoint;
  }

  @Override
  public byte[] serialize() {
    return new byte[0];
  }

  @Override
  public PartitionGroupMetadata deserialize(byte[] blob) {
    return null;
  }
}